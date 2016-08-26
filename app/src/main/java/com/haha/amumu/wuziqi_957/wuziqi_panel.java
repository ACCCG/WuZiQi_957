package com.haha.amumu.wuziqi_957;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by amumu on 2016/8/19.
 */
public class wuziqi_panel extends View {


    private int mPanelWidth;
    private float mLineHeight;
    private int Max_Line = 10;
    private Paint mPaint = new Paint();//绘制 的棋盘的线

    public wuziqi_panel(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(0x44ff0000);//有半透明效果

        init();
    }

    /**
     * 棋盘线的初始化
     * */
    private void init() {

        mPaint.setColor(0x88000000);//透明
        mPaint.setStyle(Paint.Style.STROKE);//实线
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        //获取 长宽的大小及属性
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int width = Math.min(widthSize,heightSize);//为避免其中又不期望的值出现导致错乱,比如0，加判断

        if(widthMode == MeasureSpec.UNSPECIFIED){
            width = widthSize;
        }else if(heightMode == MeasureSpec.UNSPECIFIED){
            width = heightSize;
        }

        setMeasuredDimension(width,width);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //这个方法会在这个view的大小发生改变是被系统调用，我们要记住的就是view大小变化
        mPanelWidth = w;
        mLineHeight = mPanelWidth * 1.0f / Max_Line;//转换为float
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drewBoard(canvas);

    }

    /**
     *   专门画棋盘
     * */
    private void drewBoard(Canvas canvas) {

        int w = mPanelWidth;
        float lineHeight = mLineHeight;
        for(int i = 0 ; i <Max_Line ; i++ ){
            //起点和终点
            int startX = (int) (lineHeight / 2);
            int endX = (int) (w - lineHeight / 2);

            int y = (int) (( 0.5 + i ) * lineHeight);

            canvas.drawLine(startX,y,endX,y,mPaint);//横线
            canvas.drawLine(y,startX,y,endX,mPaint);//竖线
        }

    }
}
