package com.chad.library.adapter.base.util;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by yuanjunhua on 2017/7/23.
 * 功能：图片显示加载管理器 使用 Glide
 * 双重枷锁校验
 */

public class ImageManager {
private volatile static ImageManager instance;
    private ImageManager(){}
    public   static ImageManager getInstance(){
        if(null == instance){
            synchronized (ImageManager.class){
                if(null == instance){
                    instance = new ImageManager();
                }
            }
        }

        return instance;
    }


    /**
     * 功能：使用 url 显示图片
     * @param mContext
     * @param imageView 显示图的控件View
     * @param url 图片的str地址
     * @param type 显示图片样式的类型
     */
    public void showImageByUrl(Context mContext, ImageView imageView, String url, ImageType type) {
//        switch (type) {
//            case Mask://使用mask背景衬托的图片显示
//                int mWidth = rlUtils.dip2px(mContext, 133.33f);
//                int mHeight = rlUtils.dip2px(mContext, 126.33f);
//                Glide.with(mContext)
//                        .load(url)
//                        .override(mWidth, mHeight)
//                        .bitmapTransform(new CenterCrop(mContext),
//                                new MaskTransformation(mContext, R.mipmap.intentphoto))
//                        .into(imageView);
//                break;
//
//            case NinePatchMask://使用点九mask背景衬托的图片显示
//                int nWidth = rlUtils.dip2px(mContext, 150.0f);
//                int nWeight = rlUtils.dip2px(mContext, 100.0f);
//                Glide.with(mContext)
//                        .load(url)
//                        .override(nWidth, nWeight)
//                        .bitmapTransform(new CenterCrop(mContext),
//                                new MaskTransformation(mContext, R.mipmap.intentphoto))
//                        .into(imageView);
//                break;
//
//            case CropTop:
//                Glide.with(mContext)
//                        .load(url)
//                        .bitmapTransform(
//                                new CropTransformation(mContext, 300, 100, CropTransformation.CropType.TOP))
//                        .into(imageView);
//                break;
//            case CropCenter:
//                Glide.with(mContext)
//                        .load(url)
//                        .bitmapTransform(new CropTransformation(mContext, 300, 100))
//                        .into(imageView);
//                break;
//            case CropBottom:
//                Glide.with(mContext)
//                        .load(url)
//                        .bitmapTransform(
//                                new CropTransformation(mContext, 300, 100, CropTransformation.CropType.BOTTOM))
//                        .into(imageView);
//
//                break;
//            case CropSquare:
//                Glide.with(mContext)
//                        .load(url)
//                        .bitmapTransform(new CropSquareTransformation(mContext))
//                        .into(imageView);
//                break;
//            case CropCircle:
//                Glide.with(mContext)
//                        .load(url)
//                        .bitmapTransform(new CropCircleTransformation(mContext))
//                        .into(imageView);
//                break;
//            case ColorFilter:
//                Glide.with(mContext)
//                        .load(url)
//                        .bitmapTransform(new ColorFilterTransformation(mContext, Color.argb(80, 255, 0, 0)))
//                        .into(imageView);
//                break;
//            case Grayscale:
//                Glide.with(mContext)
//                        .load(url)
//                        .bitmapTransform(new GrayscaleTransformation(mContext))
//                        .into(imageView);
//                break;
//            case RoundedCorners:
//                Glide.with(mContext)
//                        .load(url)
//                        .bitmapTransform(new RoundedCornersTransformation(mContext, 30, 0,
//                                RoundedCornersTransformation.CornerType.BOTTOM))
//                        .into(imageView);
//                break;
//            case Blur:
//                Glide.with(mContext)
//                        .load(url)
//                        .bitmapTransform(new BlurTransformation(mContext, 25))
//                        .into(imageView);
//                break;
//            case Toon:
//                Glide.with(mContext)
//                        .load(url)
//                        .bitmapTransform(new ToonFilterTransformation(mContext))
//                        .into(imageView);
//                break;
//            case Sepia:
//                Glide.with(mContext)
//                        .load(url)
//                        .bitmapTransform(new SepiaFilterTransformation(mContext))
//                        .into(imageView);
//                break;
//            case Contrast:
//                Glide.with(mContext)
//                        .load(url)
//                        .bitmapTransform(new ContrastFilterTransformation(mContext, 2.0f))
//                        .into(imageView);
//                break;
//            case Invert:
//                Glide.with(mContext)
//                        .load(url)
//                        .bitmapTransform(new InvertFilterTransformation(mContext))
//                        .into(imageView);
//                break;
//            case Pixel:
//                Glide.with(mContext)
//                        .load(url)
//                        .bitmapTransform(new PixelationFilterTransformation(mContext, 20))
//                        .into(imageView);
//                break;
//            case Sketch:
//                Glide.with(mContext)
//                        .load(url)
//                        .bitmapTransform(new SketchFilterTransformation(mContext))
//                        .into(imageView);
//                break;
//            case Swirl:
//                Glide.with(mContext)
//                        .load(url)
//                        .bitmapTransform(
//                                new SwirlFilterTransformation(mContext, 0.5f, 1.0f, new PointF(0.5f, 0.5f)))
//                        .into(imageView);
//                break;
//            case Brightness:
//                Glide.with(mContext)
//                        .load(url)
//                        .bitmapTransform(new BrightnessFilterTransformation(mContext, 0.5f))
//                        .into(imageView);
//                break;
//            case Kuawahara:
//                Glide.with(mContext)
//                        .load(url)
//                        .bitmapTransform(new KuwaharaFilterTransformation(mContext, 25))
//                        .into(imageView);
//                break;
//            case Vignette:
//                Glide.with(mContext)
//                        .load(url)
//                        .bitmapTransform(new VignetteFilterTransformation(mContext, new PointF(0.5f, 0.5f),
//                                new float[] { 0.0f, 0.0f, 0.0f }, 0f, 0.75f))
//                        .into(imageView);
//                break;
//        }
    }


    /**
     * 功能：使用 drawable 显示图片
     * @param mContext
     * @param imageView 显示图的控件View
     * @param drawable 图片的 drawable
     * @param type 显示图片样式的类型
     */
    public void showImageByDrawable(Context mContext, ImageView imageView, int drawable, ImageType type) {
//        switch (type) {
//            case Mask: {
//                int width = rlUtils.dip2px(mContext, 133.33f);
//                int height = rlUtils.dip2px(mContext, 126.33f);
//                Glide.with(mContext)
//                        .load(drawable)
//                        .override(width, height)
//                        .bitmapTransform(new CenterCrop(mContext),
//                                new MaskTransformation(mContext, R.mipmap.intentphoto))
//                        .into(imageView);
//                break;
//            }
//            case NinePatchMask: {
//                int width = rlUtils.dip2px(mContext, 150.0f);
//                int height = rlUtils.dip2px(mContext, 100.0f);
//                Glide.with(mContext)
//                        .load(drawable)
//                        .override(width, height)
//                        .bitmapTransform(new CenterCrop(mContext),
//                                new MaskTransformation(mContext, R.mipmap.intentphoto))
//                        .into(imageView);
//                break;
//            }
//            case CropTop:
//                Glide.with(mContext)
//                        .load(drawable)
//                        .bitmapTransform(
//                                new CropTransformation(mContext, 300, 100, CropTransformation.CropType.TOP))
//                        .into(imageView);
//                break;
//            case CropCenter:
//                Glide.with(mContext)
//                        .load(drawable)
//                        .bitmapTransform(new CropTransformation(mContext, 300, 100))
//                        .into(imageView);
//                break;
//            case CropBottom:
//                Glide.with(mContext)
//                        .load(drawable)
//                        .bitmapTransform(
//                                new CropTransformation(mContext, 300, 100, CropTransformation.CropType.BOTTOM))
//                        .into(imageView);
//
//                break;
//            case CropSquare:
//                Glide.with(mContext)
//                        .load(drawable)
//                        .bitmapTransform(new CropSquareTransformation(mContext))
//                        .into(imageView);
//                break;
//            case CropCircle:
//                Glide.with(mContext)
//                        .load(drawable)
//                        .bitmapTransform(new CropCircleTransformation(mContext))
//                        .into(imageView);
//                break;
//            case ColorFilter:
//                Glide.with(mContext)
//                        .load(drawable)
//                        .bitmapTransform(new ColorFilterTransformation(mContext, Color.argb(80, 255, 0, 0)))
//                        .into(imageView);
//                break;
//            case Grayscale:
//                Glide.with(mContext)
//                        .load(drawable)
//                        .bitmapTransform(new GrayscaleTransformation(mContext))
//                        .into(imageView);
//                break;
//            case RoundedCorners:
//                Glide.with(mContext)
//                        .load(drawable)
//                        .bitmapTransform(new RoundedCornersTransformation(mContext, 30, 0,
//                                RoundedCornersTransformation.CornerType.BOTTOM))
//                        .into(imageView);
//                break;
//            case Blur:
//                Glide.with(mContext)
//                        .load(drawable)
//                        .bitmapTransform(new BlurTransformation(mContext, 25))
//                        .into(imageView);
//                break;
//            case Toon:
//                Glide.with(mContext)
//                        .load(drawable)
//                        .bitmapTransform(new ToonFilterTransformation(mContext))
//                        .into(imageView);
//                break;
//            case Sepia:
//                Glide.with(mContext)
//                        .load(drawable)
//                        .bitmapTransform(new SepiaFilterTransformation(mContext))
//                        .into(imageView);
//                break;
//            case Contrast:
//                Glide.with(mContext)
//                        .load(drawable)
//                        .bitmapTransform(new ContrastFilterTransformation(mContext, 2.0f))
//                        .into(imageView);
//                break;
//            case Invert:
//                Glide.with(mContext)
//                        .load(drawable)
//                        .bitmapTransform(new InvertFilterTransformation(mContext))
//                        .into(imageView);
//                break;
//            case Pixel:
//                Glide.with(mContext)
//                        .load(drawable)
//                        .bitmapTransform(new PixelationFilterTransformation(mContext, 20))
//                        .into(imageView);
//                break;
//            case Sketch:
//                Glide.with(mContext)
//                        .load(drawable)
//                        .bitmapTransform(new SketchFilterTransformation(mContext))
//                        .into(imageView);
//                break;
//            case Swirl:
//                Glide.with(mContext)
//                        .load(drawable)
//                        .bitmapTransform(
//                                new SwirlFilterTransformation(mContext, 0.5f, 1.0f, new PointF(0.5f, 0.5f)))
//                        .into(imageView);
//                break;
//            case Brightness:
//                Glide.with(mContext)
//                        .load(drawable)
//                        .bitmapTransform(new BrightnessFilterTransformation(mContext, 0.5f))
//                        .into(imageView);
//                break;
//            case Kuawahara:
//                Glide.with(mContext)
//                        .load(drawable)
//                        .bitmapTransform(new KuwaharaFilterTransformation(mContext, 25))
//                        .into(imageView);
//                break;
//            case Vignette:
//                Glide.with(mContext)
//                        .load(drawable)
//                        .bitmapTransform(new VignetteFilterTransformation(mContext, new PointF(0.5f, 0.5f),
//                                new float[] { 0.0f, 0.0f, 0.0f }, 0f, 0.75f))
//                        .into(imageView);
//                break;
//        }
    }

//    enum Type {
//        Mask,
//        NinePatchMask,
//        CropTop,
//        CropCenter,
//        CropBottom,
//        CropSquare,
//        CropCircle,
//        ColorFilter,
//        Grayscale,
//        RoundedCorners,
//        Blur,
//        Toon,
//        Sepia,
//        Contrast,
//        Invert,
//        Pixel,
//        Sketch,
//        Swirl,
//        Brightness,
//        Kuawahara,
//        Vignette
//    }
}
