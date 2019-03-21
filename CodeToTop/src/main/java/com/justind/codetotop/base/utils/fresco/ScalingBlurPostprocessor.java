package com.justind.codetotop.base.utils.fresco;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;

public class ScalingBlurPostprocessor extends BasePostprocessor {
  private final Paint mPaint = new Paint();
  private final int mIterations;
  private final int mBlurRadius;
  /**
   * A scale ration of 4 means that we reduce the total number of pixels to process by factor 16.
   */
  private final int SCALE_RATIO;

  public ScalingBlurPostprocessor(int iterations, int blurRadius, int scaleRatio) {
    mIterations = iterations;
    mBlurRadius = blurRadius;
    SCALE_RATIO = scaleRatio;
  }

  @Override
  public CloseableReference<Bitmap> process(
          Bitmap sourceBitmap,
          PlatformBitmapFactory bitmapFactory) {
    final CloseableReference<Bitmap> bitmapRef = bitmapFactory.createBitmap(
            sourceBitmap.getWidth() / SCALE_RATIO,
            sourceBitmap.getHeight() / SCALE_RATIO);

    try {
      final Bitmap destBitmap = bitmapRef.get();
      final Canvas canvas = new Canvas(destBitmap);

      canvas.drawBitmap(
              sourceBitmap,
              null,
              new Rect(0, 0, destBitmap.getWidth(), destBitmap.getHeight()),
              mPaint);

      NativeBlurFilter.iterativeBoxBlur(destBitmap, mIterations, mBlurRadius / SCALE_RATIO);

      return CloseableReference.cloneOrNull(bitmapRef);
    } finally {
      CloseableReference.closeSafely(bitmapRef);
    }
  }
}
