package com.rafaelneiva.circletodropanimation

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

/**
 * Created by rafaelneiva on 01/11/18.
 */
class WaterDropView : View {

    private var dX = 0f
    private var dY = 0f
    lateinit var circlePaint: Paint
    lateinit var dropPaint: Paint
    lateinit var path: Path
    private var circleRadius = 100f
    private var dropRadius = 10f

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        init()
    }

    private fun init() {
        circlePaint = Paint(Paint.ANTI_ALIAS_FLAG)
        dropPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        path = Path()

        circlePaint.color = Color.CYAN
        dropPaint.color = Color.MAGENTA
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawCircle(
            (width / 2).toFloat(),
            (height / 2).toFloat(),
            circleRadius,
            circlePaint
        )
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        circleRadius = (h / 2).toFloat()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                dX = x - event.rawX
                dY = y - event.rawY

                Log.i("x - y: ", "$dX - $dY")
            }
            MotionEvent.ACTION_MOVE -> {
                x = event.rawX + dX
                y = event.rawY + dY
            }
            else -> return false
        }
        return true
    }

}