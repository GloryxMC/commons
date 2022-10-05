package cat.ui.text

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontSynthesis
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.LocaleList
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextGeometricTransform
import androidx.compose.ui.unit.TextUnit

infix fun String.withColor(color: Color) = annotate(color)

fun String.annotate(
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontWeight: FontWeight? = null,
    fontStyle: FontStyle? = null,
    fontSynthesis: FontSynthesis? = null, fontFamily: FontFamily? = null,
    fontFeatureSettings: String? = null, letterSpacing: TextUnit = TextUnit.Unspecified,
    baselineShift: BaselineShift? = null, textGeometricTransform: TextGeometricTransform? = null,
    localeList: LocaleList? = null, background: Color = Color.Unspecified, textDecoration: TextDecoration? = null,
    shadow: Shadow? = null
) = AnnotatedString(
    this, SpanStyle(
        color,
        fontSize,
        fontWeight,
        fontStyle,
        fontSynthesis,
        fontFamily,
        fontFeatureSettings,
        letterSpacing,
        baselineShift,
        textGeometricTransform,
        localeList,
        background,
        textDecoration,
        shadow
    )
)

infix fun String.and(annotated: AnnotatedString) = AnnotatedString(this) + annotated