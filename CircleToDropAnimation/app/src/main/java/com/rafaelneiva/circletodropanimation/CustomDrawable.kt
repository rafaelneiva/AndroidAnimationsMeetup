package com.rafaelneiva.circletodropanimation

import android.graphics.*
import android.graphics.drawable.Drawable
import kotlin.math.min

/**
 * Created by rafaelneiva on 01/11/18.
 */
class CustomDrawable(private val bgColor: Int) : Drawable() {

    lateinit var starPaint: Paint
    private val path = Path()

    init {
        init()
    }

    private fun init() {
        starPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        starPaint.color = bgColor
    }

    override fun draw(canvas: Canvas) {

        var mid = bounds.width() / 2.toFloat()
        val min = min(bounds.width(), bounds.height()).toFloat()
        val fat = min / 17
        val half = min / 2
        val rad = half - fat
        mid -= half

        starPaint.strokeWidth = fat
        starPaint.style = Paint.Style.STROKE

        canvas.drawCircle(mid + half, half, rad, starPaint)

        path.reset()

        starPaint.style = Paint.Style.FILL

        path.moveTo(mid + half * 0.5f, half * 0.84f)
        path.lineTo(mid + half * 1.5f, half * 0.84f)
        path.lineTo(mid + half * 0.68f, half * 1.45f)
        path.lineTo(mid + half * 1.0f, half * 0.5f)
        path.lineTo(mid + half * 1.32f, half * 1.45f)
        path.lineTo(mid + half * 0.5f, half * 0.84f)

        path.close()
        canvas.drawPath(path, starPaint)
    }

    override fun setAlpha(alpha: Int) {
        starPaint.alpha = alpha
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        starPaint.colorFilter = colorFilter
    }

}