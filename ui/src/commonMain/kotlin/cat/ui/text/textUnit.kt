package cat.ui.text

import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import cat.f

@OptIn(ExperimentalUnitApi::class)
fun textUnit(value: Number, unit: TextUnitType = TextUnitType.Sp) = TextUnit(value.f, unit)