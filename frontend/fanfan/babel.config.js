module.exports = {
  presets: [
    '@vue/cli-plugin-babel/preset'
  ],
  css: {
    loaderOptions: {
      // 给 sass-loader 传递选项
      scss: {
        // @/ 是 src/ 的别名
        // 注意：在 sass-loader v7 中，这个选项名是 "data"
        prependData: `
            @import "@/assets/css/custom_theme.scss";
            @import "@nutui/nutui/dist/styles/index.scss";
            `,
      }
    }
  }
}
