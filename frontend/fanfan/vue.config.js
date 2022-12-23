const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  "plugins": [
    ["@nutui/babel-plugin-separate-import", {
      "style": "scss"
    }]
  ]
})
