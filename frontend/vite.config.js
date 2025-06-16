import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

// https://vite.dev/config/
export default defineConfig({
  base: "./", // 讓 assets 路徑是相對路徑
  plugins: [react()],

  build: {
    outDir: "../backend/src/main/resources/static",
    emptyOutDir: true, // 每次打包清空舊的
  },
});
