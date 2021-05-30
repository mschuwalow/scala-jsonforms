{

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
    flake-utils.url = "github:numtide/flake-utils";
  };

  outputs = { self, nixpkgs, flake-utils }:

    flake-utils.lib.simpleFlake {
      inherit self nixpkgs;
      name = "scala-jsonforms";
      preOverlays = [
        (self: super: {
          jre = super.jdk11;
          jdk = super.jdk11;
        })
      ];
      overlay = ./nix/overlay.nix;
      shell = ./nix/shell.nix;
      systems = [ "x86_64-darwin" "x86_64-linux" ];
    };
}
