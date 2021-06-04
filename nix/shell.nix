{ pkgs }:
pkgs.mkShell { buildInputs = with pkgs; [ gnumake nixfmt sbt fd nodejs ]; }
