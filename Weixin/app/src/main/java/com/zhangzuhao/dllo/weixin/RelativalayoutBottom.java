package com.zhangzuhao.dllo.weixin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by dllo on 16/9/18.
 */
public class RelativalayoutBottom extends RelativeLayout {
    //定义布局的宽和高
    private int width;
    private int height;
    //定义图片的宽和高
    private int iconwidth;
    private int iconheigth;
    //图片所在矩形的位置
    private Rect iconRect;
    private Context context;
    private final String GAT = this.getClass().getSimpleName();
    //显示图片
    private ImageView iv;
    //显示文字
    private TextView tv;
    //字体左边和顶部
    private int textLeft, textTop;
    private Bitmap mBitmap;
    //将图片转换
    private Bitmap ivBmBG;
    //设置颜色的百分比(0-1);
    private float mPercent;


    public RelativalayoutBottom(Context context) {
        super(context);
    }

    public RelativalayoutBottom(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RelativalayoutBottom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        setWillNotDraw(false);
    }
    //重新获取宽和高

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
        //初始化组件
        initView();
        //初始化矩形
        initRect();
    }


    private void initRect() {
        //获得文字的宽高
        Rect textRect = getTextBounds(tv.getText().toString(),tv.getTextSize());
        int iconLeft = width/2-iconwidth/2;
        int iconTop = (int) (height/2-iconheigth-textRect.height()*0.6667);

        iconRect = new Rect(iconLeft,iconTop,iconLeft+iconwidth,iconTop+iconheigth);
        this.textLeft =width/2-textRect.width()/2;
        this.textTop = height-textRect.bottom*3;
    }



    private void initView() {
        iv = (ImageView) findViewById(R.id.iv);
        tv = (TextView) findViewById(R.id.tv);

        iv.setVisibility(View.INVISIBLE);
        tv.setVisibility(View.INVISIBLE);
        ivBmBG = ((BitmapDrawable) iv.getBackground()).getBitmap();
        iconwidth = ivBmBG.getWidth();
        iconheigth = ivBmBG.getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int alpha = (int) Math.ceil(255*mPercent);

        canvas.drawBitmap(ivBmBG,null,iconRect,null);
        setNewGreenCanvas(alpha);
        setResText(canvas,255-alpha);
        setDesText(canvas,alpha);
        canvas.drawBitmap(mBitmap,0,0,null);

    }

    private void setDesText(Canvas canvas, int alpha) {
        Paint mPaint = new Paint();
        mPaint.setTextSize(tv.getTextSize());
        mPaint.setColor(Color.GREEN);
        mPaint.setAntiAlias(true);
        mPaint.setAlpha(alpha);
        canvas.drawText(tv.getText().toString(),textLeft,textTop,mPaint);
    }

    private void setResText(Canvas canvas, int alpha) {
        Paint mPaint = new Paint();
        mPaint.setTextSize(tv.getTextSize());
        mPaint.setColor(0Xff555555);
        mPaint.setAntiAlias(true);
        mPaint.setAlpha(alpha);
        canvas.drawText(tv.getText().toString(),textLeft,textTop,mPaint);
    }

    //设置一个绿色的新画布
    private void setNewGreenCanvas(int alpha) {
        this.mBitmap = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);
        Canvas mCanvas = new Canvas(mBitmap);
        Paint mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setAntiAlias(true);
        mPaint.setAlpha(alpha);
        mCanvas.drawRect(iconRect,mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        mCanvas.drawBitmap(ivBmBG,null,iconRect,mPaint);

    }
    private Rect getTextBounds(String text, float textSize) {
        Rect r = new Rect();
        Paint p = new Paint();
        p.setTextSize(textSize);
        p.getTextBounds(text,0,text.length(),r);
        return r;
    }
    //设置颜色的百分比
    @Override
    public void setAlpha(float percent) {
        this.mPercent = percent;
        invalidate();

    }
}
