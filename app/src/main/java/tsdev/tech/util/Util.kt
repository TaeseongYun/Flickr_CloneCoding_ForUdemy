package tsdev.tech.util

import android.support.annotation.IdRes
import android.support.v7.app.AppCompatActivity
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

fun AppCompatActivity.replace(@IdRes frameId: Int, fragment: android.support.v4.app.Fragment, tag: String? = null) =
        supportFragmentManager.beginTransaction().replace(frameId, fragment, tag).commit()

fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start)


fun String.getDate(dataFormat: String): String {
        val calendar = Calendar.getInstance().apply {
                timeInMillis = this@getDate.toLong() * 1000
        }
        return SimpleDateFormat(dataFormat, Locale.getDefault()).format(calendar.time)
}

fun String.decimalFormat(): String {
        return DecimalFormat("#,###").format(this.toLong())
}