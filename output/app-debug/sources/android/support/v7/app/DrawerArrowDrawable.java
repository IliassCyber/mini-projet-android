package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R;

/* JADX INFO: loaded from: classes.dex */
abstract class DrawerArrowDrawable extends Drawable {
    private static final float ARROW_HEAD_ANGLE = (float) Math.toRadians(45.0d);
    private final float mBarGap;
    private final float mBarSize;
    private final float mBarThickness;
    private float mCenterOffset;
    private float mMaxCutForBarSize;
    private final float mMiddleArrowSize;
    private float mProgress;
    private final int mSize;
    private final boolean mSpin;
    private final float mTopBottomArrowSize;
    private final Paint mPaint = new Paint();
    private final Path mPath = new Path();
    private boolean mVerticalMirror = false;

    abstract boolean isLayoutRtl();

    DrawerArrowDrawable(Context context) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(typedArray.getColor(R.styleable.DrawerArrowToggle_color, 0));
        this.mSize = typedArray.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.mBarSize = Math.round(typedArray.getDimension(R.styleable.DrawerArrowToggle_barSize, 0.0f));
        this.mTopBottomArrowSize = Math.round(typedArray.getDimension(R.styleable.DrawerArrowToggle_topBottomBarArrowSize, 0.0f));
        this.mBarThickness = typedArray.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0f);
        this.mBarGap = Math.round(typedArray.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0f));
        this.mSpin = typedArray.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true);
        this.mMiddleArrowSize = typedArray.getDimension(R.styleable.DrawerArrowToggle_middleBarArrowSize, 0.0f);
        float f = this.mSize;
        float f2 = this.mBarThickness;
        float f3 = this.mBarGap;
        int remainingSpace = (int) ((f - (3.0f * f2)) - (f3 * 2.0f));
        this.mCenterOffset = (remainingSpace / 4) * 2;
        double d = this.mCenterOffset;
        double d2 = f2;
        Double.isNaN(d2);
        double d3 = f3;
        Double.isNaN(d3);
        Double.isNaN(d);
        this.mCenterOffset = (float) (d + (d2 * 1.5d) + d3);
        typedArray.recycle();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.MITER);
        this.mPaint.setStrokeCap(Paint.Cap.BUTT);
        this.mPaint.setStrokeWidth(this.mBarThickness);
        double d4 = this.mBarThickness / 2.0f;
        double dCos = Math.cos(ARROW_HEAD_ANGLE);
        Double.isNaN(d4);
        this.mMaxCutForBarSize = (float) (d4 * dCos);
    }

    protected void setVerticalMirror(boolean verticalMirror) {
        this.mVerticalMirror = verticalMirror;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        boolean isRtl = isLayoutRtl();
        float arrowSize = lerp(this.mBarSize, this.mTopBottomArrowSize, this.mProgress);
        float middleBarSize = lerp(this.mBarSize, this.mMiddleArrowSize, this.mProgress);
        float middleBarCut = Math.round(lerp(0.0f, this.mMaxCutForBarSize, this.mProgress));
        float rotation = lerp(0.0f, ARROW_HEAD_ANGLE, this.mProgress);
        float canvasRotate = lerp(isRtl ? 0.0f : -180.0f, isRtl ? 180.0f : 0.0f, this.mProgress);
        double d = arrowSize;
        double dCos = Math.cos(rotation);
        Double.isNaN(d);
        float arrowWidth = Math.round(d * dCos);
        double d2 = arrowSize;
        double dSin = Math.sin(rotation);
        Double.isNaN(d2);
        float arrowHeight = Math.round(d2 * dSin);
        this.mPath.rewind();
        float topBottomBarOffset = lerp(this.mBarGap + this.mBarThickness, -this.mMaxCutForBarSize, this.mProgress);
        float arrowEdge = (-middleBarSize) / 2.0f;
        this.mPath.moveTo(arrowEdge + middleBarCut, 0.0f);
        this.mPath.rLineTo(middleBarSize - (2.0f * middleBarCut), 0.0f);
        this.mPath.moveTo(arrowEdge, topBottomBarOffset);
        this.mPath.rLineTo(arrowWidth, arrowHeight);
        this.mPath.moveTo(arrowEdge, -topBottomBarOffset);
        this.mPath.rLineTo(arrowWidth, -arrowHeight);
        this.mPath.close();
        canvas.save();
        canvas.translate(bounds.centerX(), this.mCenterOffset);
        if (this.mSpin) {
            canvas.rotate((this.mVerticalMirror ^ isRtl ? -1 : 1) * canvasRotate);
        } else if (isRtl) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.mPath, this.mPaint);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mSize;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mSize;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float getProgress() {
        return this.mProgress;
    }

    public void setProgress(float progress) {
        this.mProgress = progress;
        invalidateSelf();
    }

    private static float lerp(float a, float b, float t) {
        return ((b - a) * t) + a;
    }
}
