const { defineConfig } = require('@vue/cli-service')
const path = require('path')

const { NODE_ENV, VUE_APP_TITLE = '' } = process.env

const config = {
  transpileDependencies: false,
  productionSourceMap: NODE_ENV === 'production',
  chainWebpack: (setting) => {
    setting.plugin('html').tap((args) => {
      args[0].APP_TITLE = VUE_APP_TITLE
      return args
    })
  },
  css: {
    loaderOptions: {
      less: {
        lessOptions: {
          javascriptEnabled: true,
        }
      }
    }
  },
  pluginOptions: {
    'style-resources-loader': {
      preProcessor: 'less',
      patterns: [
        path.resolve(__dirname, 'src/styles/variable.less')
      ]
    }
  },
  // devServer: {
  //   proxy: {
  //     '/api': {
  //       target: 'http://124.220.158.211:7000/',// 后端接口
  //       changeOrigin: true, // 是否跨域
  //       pathRewrite: {
  //         '/api': ''
  //       }
  //     }
  //   }
  // }
}

module.exports = defineConfig(config)


