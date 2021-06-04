self: super:

let
  inherit (super) pkgs lib;
  inherit (pkgs) writeScriptBin;
  inherit (pkgs.stdenv) mkDerivation;
  inherit (lib) sources;

  checkScript = writeScriptBin "runCheck" ''
    sbt -Duser.home=$HOME +test
  '';

  mkCheck = jdk: nodejs:
    mkDerivation rec {
      name = "scala-jsonschema-check-${jdk}-${nodejs}";
      version = "latest";

      src =
        sources.sourceByRegex ../. [ "^build.sbt$" "^project.*" "^modules.*" ];

      nativeBuildInputs =
        [ pkgs."${jdk}" pkgs."${nodejs}" pkgs.sbt checkScript ];

      inputString = toString src;
      outputHashAlgo = "sha256";
      outputHash = builtins.hashString "sha256" inputString;

      dontBuild = true;
      dontFixup = true;
      doCheck = true;

      checkPhase = ''
        runHook preCheck
        export HOME=$(mktemp -d)
        runCheck
        runHook postCheck
      '';

      installPhase = ''
        runHook preInstall
        echo -n "$inputString" > $out
        runHook postInstall
      '';
    };

in {
  scala-jsonschema = {
    checks = {
      latest = mkCheck "jdk" "nodejs";
      jdk8-nodejs14 = mkCheck "jdk8" "nodejs-14_x";
      jdk11-nodejs14 = mkCheck "jdk11" "nodejs-14_x";
    };
  };
}
