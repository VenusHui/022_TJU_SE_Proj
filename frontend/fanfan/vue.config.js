const { defineConfig } = require('@vue/cli-service')
const path = require('path')

const { NODE_ENV, VUE_APP_TITLE = '' } = process.env

var webpack = require('webpack');

module.exports = {
  publicPath:'./',
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
  configureWebpack: {
    plugins: [
      new webpack.ProvidePlugin({
        $: "jquery",
        jQuery: "jquery",
      })
    ]
  }

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

