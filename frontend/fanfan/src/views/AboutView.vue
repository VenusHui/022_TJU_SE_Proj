<template>

<div class="box-wrapper">
  <div class="bottom">
    <div class="box-content">
      <a class="buy" href="javascript:void(0)"><span><img src="../assets/fander-icon-white.png" width="60" height="60"></span></a>
    </div>
  </div>
  <div class="success"></div>
</div>
</template>

<script>
jQuery(document).ready(function($) {
	$('.buy').on('click', function(e) {
		e.preventDefault();

		$('body').toggleClass('expanded');
	})
});
</script>

<style lang="scss">

.bottom {
    width: 120%;
    height: 10%;
    margin-left: 10%;
    align-self: flex-end;
    padding-bottom: 10%;
}

.box-wrapper {
	background-color: #fff;
	overflow: hidden;
	width: 320px;
  height: 400px;
	box-shadow: 0px 5px 43px rgba( 0, 0, 0, 0.48 );
	padding: 0;
	text-align: center;
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-50%,-50%);

	.success {
		position:absolute;
		top:50%;
		left:37%;
		transform: translate(-50%,-50%);
		opacity: 0;
		z-index: 999;

		.expanded & {
			opacity:1;
			transition: opacity 0.3s 0.6s;
		}

		&:before,
		&:after {
			content: '';
			display: block;
			position: absolute;
			background-color: #fff;
		}

		&:before {
			width: 40px;
			height: 20px;
			transform: rotate(45deg);
		}

		&:after {
			width: 88px;
			height: 20px;
			transform: rotate(-45deg);
			top: -16px;
			left: 8px;
		}
	}
}


.box-content{
  position: relative;
  z-index: 1; 
  display: flex;
  
  .buy {
    // display: block;
    top: 80%;
    right: 50%;
    z-index: 2;
    width: 70px;
	  height: 70px;
	  position: absolute;
    align-self: flex-end;
    
    span {
      // 圆圈大小
		  width: 70px;
      height: 70px;
      background-color: #ff0800;
      display: block;
      border-radius: 50%;
      position: absolute;
      font-size: 36px; 
      color: #fff;
      transition: all 0.3s ease;
      transform: translate(-50%,-50%);
      
      
      i {
        padding: 15px;
      }

		  .expanded & {
			  width: 950px;
			  height: 950px;
        
        i {
          display: none;
        }
		  }
    }
  }
  
  
}
</style>

