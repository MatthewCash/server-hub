{
    description = "Server Hub Minecraft Plugin";

    inputs = {
        nixpkgs.url = "nixpkgs/nixos-unstable";
        flake-utils.url = "github:numtide/flake-utils";
    };

    outputs = { nixpkgs, flake-utils, ... }:
    flake-utils.lib.eachDefaultSystem (system:
        let pkgs = nixpkgs.legacyPackages.${system}; in {
            devShell = pkgs.mkShell {
                name = "server-hub";
                packages = with pkgs; [
                    gradle
                ];
            };
        }
    );
}
