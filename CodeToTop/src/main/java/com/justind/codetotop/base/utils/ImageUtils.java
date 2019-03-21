package com.justind.codetotop.base.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

import com.facebook.common.util.UriUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.justind.codetotop.base.utils.fresco.ScalingBlurPostprocessor;
import com.squareup.picasso.Picasso;

import java.net.URI;

public class ImageUtils {

  public static void loadImage(SimpleDraweeView simpleDraweeView, String imageUrl) {
    if (imageUrl == null) return;
    ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(Uri.parse(imageUrl))
            .build();
    simpleDraweeView.setController(
            Fresco.newDraweeControllerBuilder()
                    .setOldController(simpleDraweeView.getController())
                    .setImageRequest(imageRequest)
                    .build());
  }

  public static void loadImage(SimpleDraweeView simpleDraweeView, int imageResId) {
    Uri uri = buildUriWithResource(imageResId);
    ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(uri)
            .build();
    simpleDraweeView.setController(
            Fresco.newDraweeControllerBuilder()
                    .setOldController(simpleDraweeView.getController())
                    .setImageRequest(imageRequest)
                    .build());
  }

  public static void loadImage(SimpleDraweeView simpleDraweeView, Object image) {
    if (image == null) return;
    if (image instanceof Integer)
      loadImage(simpleDraweeView, (int) image);
    else if (image instanceof String)
      loadImage(simpleDraweeView, (String) image);
  }

  public static void loadImage(SimpleDraweeView simpleDraweeView, Object image, int imageWidth, int imageHeight) {
    if (image == null) return;
    if (image instanceof Integer)
      loadImage(simpleDraweeView, (int) image, imageWidth, imageHeight);
    else if (image instanceof String)
      loadImage(simpleDraweeView, (String) image, imageWidth, imageHeight);
  }

  public static void loadImage(SimpleDraweeView simpleDraweeView, String imageUrl, int imageWidth, int imageHeight) {
    if (imageUrl == null) return;
    ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(Uri.parse(imageUrl))
            .setResizeOptions(new ResizeOptions(imageWidth, imageHeight))
            .build();
    simpleDraweeView.setController(
            Fresco.newDraweeControllerBuilder()
                    .setOldController(simpleDraweeView.getController())
                    .setImageRequest(imageRequest)
                    .build());
  }

  public static void loadImage(SimpleDraweeView simpleDraweeView, int imageResId, int imageWidth, int imageHeight) {
    Uri uri = buildUriWithResource(imageResId);

    ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(uri)
            .setResizeOptions(new ResizeOptions(imageWidth, imageHeight))
            .build();
    simpleDraweeView.setController(
            Fresco.newDraweeControllerBuilder()
                    .setOldController(simpleDraweeView.getController())
                    .setImageRequest(imageRequest)
                    .build());
  }

  public static void loadBlurImage(SimpleDraweeView simpleDraweeView, Object imageResId, int blurRadius) {
    if (imageResId == null) return;
    ImageRequest imageRequest;
    if (imageResId instanceof Integer)
      imageRequest = ImageRequestBuilder.newBuilderWithSource(buildUriWithResource((Integer) imageResId))
              .setPostprocessor(new ScalingBlurPostprocessor(25, blurRadius, 4))
              .build();
    else
      imageRequest = ImageRequestBuilder.newBuilderWithSource(Uri.parse((String) imageResId))
              .setPostprocessor(new ScalingBlurPostprocessor(25, blurRadius, 4))
              .build();
    simpleDraweeView.setController(
            Fresco.newDraweeControllerBuilder()
                    .setOldController(simpleDraweeView.getController())
                    .setImageRequest(imageRequest)
                    .build());
  }

  public static void loadBlurImage(SimpleDraweeView simpleDraweeView, String imageUrl, int blurRadius, int imageWidth, int imageHeight) {
    ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(Uri.parse(imageUrl))
            .setPostprocessor(new ScalingBlurPostprocessor(25, blurRadius, 4))
            .setResizeOptions(new ResizeOptions(imageWidth, imageHeight))
            .build();
    simpleDraweeView.setController(
            Fresco.newDraweeControllerBuilder()
                    .setOldController(simpleDraweeView.getController())
                    .setImageRequest(imageRequest)
                    .build());
  }

  public static void loadBlurImage(SimpleDraweeView simpleDraweeView, int imageResId, int blurRadius, int imageWidth, int imageHeight) {
    ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(buildUriWithResource(imageResId))
            .setPostprocessor(new ScalingBlurPostprocessor(25, blurRadius, 4))
            .setResizeOptions(new ResizeOptions(imageWidth, imageHeight))
            .build();
    simpleDraweeView.setController(
            Fresco.newDraweeControllerBuilder()
                    .setOldController(simpleDraweeView.getController())
                    .setImageRequest(imageRequest)
                    .build());
  }

  public static void loadGifImage(SimpleDraweeView simpleDraweeView, int imageResId) {
    DraweeController controller =
            Fresco.newDraweeControllerBuilder()
                    .setUri(buildUriWithResource(imageResId))
                    .setAutoPlayAnimations(true)
                    .build();
    simpleDraweeView.setController(controller);
  }

  private static Uri buildUriWithResource(int resId) {
    return new Uri.Builder()
            .scheme(UriUtil.LOCAL_RESOURCE_SCHEME)
            .path(String.valueOf(resId))
            .build();
  }

  public static Bitmap createBitmapFromUrl(Context context, String url, int width, int height) {
    Bitmap bitmap = null;
    try {
      URI uri = new URI(url);
      bitmap = Picasso.with(context)
              .load(uri.toString())
              .resize(width, height)
              .get();
    } catch (Exception e) {
    }
    return bitmap;
  }
}
