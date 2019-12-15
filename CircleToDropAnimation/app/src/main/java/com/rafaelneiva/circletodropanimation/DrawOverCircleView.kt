package com.rafaelneiva.circletodropanimation

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin


/**
 * Created by rafaelneiva on 13/11/16.
 */
class DrawOverCircleView : View {
    lateinit var mTextPaint: TextPaint
    lateinit var mCirclePaint: Paint
    lateinit var mCircleRect: RectF
    private var mHeight = 0f
    private var mWidth = 0f
    private val mCirclePadding = 60f
    private var mAngle = 1.0

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context,
        attrs
    ) {
        init()
    }

    private fun init() {
        mTextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
        mTextPaint.color = Color.DKGRAY
        mTextPaint.textSize = 30f
        mCirclePaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mCirclePaint.color = Color.GRAY
        mCirclePaint.style = Paint.Style.STROKE
        mCirclePaint.strokeWidth = 2f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val radius = mCircleRect.width() / 2
        val cx = mCircleRect.centerX()
        val cy = mCircleRect.centerY()
        val angle = Math.toRadians(mAngle).toFloat()
        val scaleMarkSize = radius - resources.displayMetrics.density * 8
        canvas.save()
        canvas.drawArc(mCircleRect, 0f, 360f, false, mCirclePaint)
        val xPos = (cx + radius * sin(angle.toDouble())).toFloat()
        val yPos = (cy - radius * cos(angle.toDouble())).toFloat()
        canvas.drawText(
            String.format(
                "%.0f",
                Math.toDegrees(angle.toDouble())
            )
            , xPos, yPos, mTextPaint
        )
        val stopX = (cx + (radius - scaleMarkSize) * sin(angle.toDouble())).toFloat()
        val stopY = (cy - (radius - scaleMarkSize) * cos(angle.toDouble())).toFloat()
        canvas.drawLine(xPos, yPos, stopX, stopY, mCirclePaint)
        canvas.restore()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        val desiredWidth = 100
        val desiredHeight = 100

        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        val width: Int
        val height: Int

        //Measure Width
        width = when (widthMode) {
            MeasureSpec.EXACTLY -> { //Must be this size
                widthSize
            }
            MeasureSpec.AT_MOST -> { //Can't be bigger than...
                min(desiredWidth, widthSize)
            }
            else -> { //Be whatever you want
                desiredWidth
            }
        }

        //Measure Height
        height = when (heightMode) {
            MeasureSpec.EXACTLY -> { //Must be this size
                heightSize
            }
            MeasureSpec.AT_MOST -> { //Can't be bigger than...
                min(desiredHeight, heightSize)
            }
            else -> { //Be whatever you want
                desiredHeight
            }
        }

        //MUST CALL THIS
        setMeasuredDimension(width, height)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mHeight = this.height.toFloat()
        mWidth = this.width.toFloat()
        mCircleRect =
            RectF(
                0 + mCirclePadding,
                0 + mCirclePadding,
                mWidth - mCirclePadding,
                mHeight - mCirclePadding
            )
    }

    fun setAngle(angle: Double) {
        mAngle = angle
        invalidate()
    }
}