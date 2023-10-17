import react from "@vitejs/plugin-react";
import vike from "vike/plugin";
import { UserConfig } from "vite";

const config: UserConfig = {
  plugins: [react(), vike()],
  // build: {
  //   outDir: "../src/main/resources/static",
  // },
};

export default config;
