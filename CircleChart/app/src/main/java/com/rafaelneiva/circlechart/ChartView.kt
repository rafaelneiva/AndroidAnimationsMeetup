package com.rafaelneiva.circlechart

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


/**
 * Created by rafaelneiva on 01/11/18.
 */
class ChartView : View {

    lateinit var bgPaint: Paint
    lateinit var progressPaint: Paint
    var progress = 100f
    lateinit var circleRectF: RectF

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
        bgPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        bgPaint.color = Color.LTGRAY
        bgPaint.style = Paint.Style.STROKE
        bgPaint.strokeWidth = 80f

        progressPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        progressPaint.style = Paint.Style.STROKE
        progressPaint.strokeWidth = 72f
        progressPaint.strokeCap = Paint.Cap.ROUND

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawArc(circleRectF, 0f, 360f, false, bgPaint)
        canvas.drawArc(circleRectF, 0f, progress, false, progressPaint)

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        circleRectF = RectF(
            0f + paddingStart,
            0f + paddingTop,
            w.toFloat() - paddingEnd,
            h.toFloat() - paddingBottom
        )

        progressPaint.shader = SweepGradient((width / 2).toFloat(), (height / 2).toFloat(), Color.CYAN, Color.MAGENTA)
    }

    fun setProgres(p: Float) {
        progress = p
        invalidate()
    }
}