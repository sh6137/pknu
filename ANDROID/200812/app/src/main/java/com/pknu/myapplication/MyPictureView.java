package com.pknu.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
//사용자 정의 위젯
public class MyPictureView extends View {


    String imagePath = null;

    public MyPictureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    //onDraw() : 재전의 해야한다. 화면의 변화가 발생하면 다시그린다.

    @Override
    protected void  onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(imagePath != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            canvas.scale(2,2,0,0);
            canvas.drawBitmap(bitmap, 0,0,null);
            bitmap.recycle();
        }
    }


}
