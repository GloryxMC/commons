@file:Suppress("unused", "nothing_to_inline")
package catfish.winder.colors

import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Stable

/**
 * Converts color [x] in RGBA to a Compose [Color]
 *
 * Note: [x] is [Int] for intellisense
 * @param x the color in RGBA notation
 * @return [Color] from [x]
 */
inline fun color(x: Int) = Color(
    value = ((x.toLong() or 0x00000000FF000000).toULong() and 0xffffffffUL) shl 32
)
/// Default
@Stable
inline val Transparent get() = Color.Transparent

@Stable
val Black = color(0x000000)
@Stable
val White = color(0xffffff)

/// Slate
@Stable
val Slate50 = color(0xf8fafc)
@Stable
val Slate100 = color(0xf1f5f9)
@Stable
val Slate200 = color(0xe2e8f0)
@Stable
val Slate300 = color(0xcbd5e1)
@Stable
val Slate400 = color(0x94a3b8)
@Stable
val Slate500 = color(0x64748b)
@Stable
val Slate600 = color(0x475569)
@Stable
val Slate700 = color(0x334155)
@Stable
val Slate800 = color(0x1e293b)
@Stable
val Slate900 = color(0x0f172a)

/// Gray
@Stable
val Gray50 = color(0xf9fafb)
@Stable
val Gray100 = color(0xf3f4f6)
@Stable
val Gray200 = color(0xe5e7eb)
@Stable
val Gray300 = color(0xd1d5db)
@Stable
val Gray400 = color(0x9ca3af)
@Stable
val Gray500 = color(0x6b7280)
@Stable
val Gray600 = color(0x4b5563)
@Stable
val Gray700 = color(0x374151)
@Stable
val Gray800 = color(0x1f2937)
@Stable
val Gray900 = color(0x111827)

/// Zinc
@Stable
val Zinc50 = color(0xfafafa)
@Stable
val Zinc100 = color(0xf4f4f5)
@Stable
val Zinc200 = color(0xe4e4e7)
@Stable
val Zinc300 = color(0xd4d4d8)
@Stable
val Zinc400 = color(0xa1a1aa)
@Stable
val Zinc500 = color(0x71717a)
@Stable
val Zinc600 = color(0x52525b)
@Stable
val Zinc700 = color(0x3f3f46)
@Stable
val Zinc800 = color(0x27272a)
@Stable
val Zinc900 = color(0x18181b)

/// Neutral
@Stable
val Neutral50 = color(0xfafafa)
@Stable
val Neutral100 = color(0xf5f5f5)
@Stable
val Neutral200 = color(0xe5e5e5)
@Stable
val Neutral300 = color(0xd4d4d4)
@Stable
val Neutral400 = color(0xa3a3a3)
@Stable
val Neutral500 = color(0x737373)
@Stable
val Neutral600 = color(0x525252)
@Stable
val Neutral700 = color(0x404040)
@Stable
val Neutral800 = color(0x262626)
@Stable
val Neutral900 = color(0x171717)

/// Stone
@Stable
val Stone50 = color(0xfafaf9)
@Stable
val Stone100 = color(0xf5f5f4)
@Stable
val Stone200 = color(0xe7e5e4)
@Stable
val Stone300 = color(0xd6d3d1)
@Stable
val Stone400 = color(0xa8a29e)
@Stable
val Stone500 = color(0x78716c)
@Stable
val Stone600 = color(0x57534e)
@Stable
val Stone700 = color(0x44403c)
@Stable
val Stone800 = color(0x292524)
@Stable
val Stone900 = color(0x1c1917)

/// Red
@Stable
val Red50 = color(0xfef2f2)
@Stable
val Red100 = color(0xfee2e2)
@Stable
val Red200 = color(0xfecaca)
@Stable
val Red300 = color(0xfca5a5)
@Stable
val Red400 = color(0xf87171)
@Stable
val Red500 = color(0xef4444)
@Stable
val Red600 = color(0xdc2626)
@Stable
val Red700 = color(0xb91c1c)
@Stable
val Red800 = color(0x991b1b)
@Stable
val Red900 = color(0x7f1d1d)

/// Orange
@Stable
val Orange50 = color(0xfff7ed)
@Stable
val Orange100 = color(0xffedd5)
@Stable
val Orange200 = color(0xfed7aa)
@Stable
val Orange300 = color(0xfdba74)
@Stable
val Orange400 = color(0xfb923c)
@Stable
val Orange500 = color(0xf97316)
@Stable
val Orange600 = color(0xea580c)
@Stable
val Orange700 = color(0xc2410c)
@Stable
val Orange800 = color(0x9a3412)
@Stable
val Orange900 = color(0x7c2d12)

/// Amber
@Stable
val Amber50 = color(0xfffbeb)
@Stable
val Amber100 = color(0xfef3c7)
@Stable
val Amber200 = color(0xfde68a)
@Stable
val Amber300 = color(0xfcd34d)
@Stable
val Amber400 = color(0xfbbf24)
@Stable
val Amber500 = color(0xf59e0b)
@Stable
val Amber600 = color(0xd97706)
@Stable
val Amber700 = color(0xb45309)
@Stable
val Amber800 = color(0x92400e)
@Stable
val Amber900 = color(0x78350f)

/// Yellow
@Stable
val Yellow50 = color(0xfefce8)
@Stable
val Yellow100 = color(0xfef9c3)
@Stable
val Yellow200 = color(0xfef08a)
@Stable
val Yellow300 = color(0xfde047)
@Stable
val Yellow400 = color(0xfacc15)
@Stable
val Yellow500 = color(0xeab308)
@Stable
val Yellow600 = color(0xca8a04)
@Stable
val Yellow700 = color(0xa16207)
@Stable
val Yellow800 = color(0x854d0e)
@Stable
val Yellow900 = color(0x713f12)

/// Lime
@Stable
val Lime50 = color(0xf7fee7)
@Stable
val Lime100 = color(0xecfccb)
@Stable
val Lime200 = color(0xd9f99d)
@Stable
val Lime300 = color(0xbef264)
@Stable
val Lime400 = color(0xa3e635)
@Stable
val Lime500 = color(0x84cc16)
@Stable
val Lime600 = color(0x65a30d)
@Stable
val Lime700 = color(0x4d7c0f)
@Stable
val Lime800 = color(0x3f6212)
@Stable
val Lime900 = color(0x365314)

/// Green
@Stable
val Green50 = color(0xf0fdf4)
@Stable
val Green100 = color(0xdcfce7)
@Stable
val Green200 = color(0xbbf7d0)
@Stable
val Green300 = color(0x86efac)
@Stable
val Green400 = color(0x4ade80)
@Stable
val Green500 = color(0x22c55e)
@Stable
val Green600 = color(0x16a34a)
@Stable
val Green700 = color(0x15803d)
@Stable
val Green800 = color(0x166534)
@Stable
val Green900 = color(0x14532d)

/// Emerald
@Stable
val Emerald50 = color(0xecfdf5)
@Stable
val Emerald100 = color(0xd1fae5)
@Stable
val Emerald200 = color(0xa7f3d0)
@Stable
val Emerald300 = color(0x6ee7b7)
@Stable
val Emerald400 = color(0x34d399)
@Stable
val Emerald500 = color(0x10b981)
@Stable
val Emerald600 = color(0x059669)
@Stable
val Emerald700 = color(0x047857)
@Stable
val Emerald800 = color(0x065f46)
@Stable
val Emerald900 = color(0x064e3b)

/// Teal
@Stable
val Teal50 = color(0xf0fdfa)
@Stable
val Teal100 = color(0xccfbf1)
@Stable
val Teal200 = color(0x99f6e4)
@Stable
val Teal300 = color(0x5eead4)
@Stable
val Teal400 = color(0x2dd4bf)
@Stable
val Teal500 = color(0x14b8a6)
@Stable
val Teal600 = color(0x0d9488)
@Stable
val Teal700 = color(0x0f766e)
@Stable
val Teal800 = color(0x115e59)
@Stable
val Teal900 = color(0x134e4a)

/// Cyan
@Stable
val Cyan50 = color(0xecfeff)
@Stable
val Cyan100 = color(0xcffafe)
@Stable
val Cyan200 = color(0xa5f3fc)
@Stable
val Cyan300 = color(0x67e8f9)
@Stable
val Cyan400 = color(0x22d3ee)
@Stable
val Cyan500 = color(0x06b6d4)
@Stable
val Cyan600 = color(0x0891b2)
@Stable
val Cyan700 = color(0x0e7490)
@Stable
val Cyan800 = color(0x155e75)
@Stable
val Cyan900 = color(0x164e63)

/// Sky
@Stable
val Sky50 = color(0xf0f9ff)
@Stable
val Sky100 = color(0xe0f2fe)
@Stable
val Sky200 = color(0xbae6fd)
@Stable
val Sky300 = color(0x7dd3fc)
@Stable
val Sky400 = color(0x38bdf8)
@Stable
val Sky500 = color(0x0ea5e9)
@Stable
val Sky600 = color(0x0284c7)
@Stable
val Sky700 = color(0x0369a1)
@Stable
val Sky800 = color(0x075985)
@Stable
val Sky900 = color(0x0c4a6e)

/// Blue
@Stable
val Blue50 = color(0xeff6ff)
@Stable
val Blue100 = color(0xdbeafe)
@Stable
val Blue200 = color(0xbfdbfe)
@Stable
val Blue300 = color(0x93c5fd)
@Stable
val Blue400 = color(0x60a5fa)
@Stable
val Blue500 = color(0x3b82f6)
@Stable
val Blue600 = color(0x2563eb)
@Stable
val Blue700 = color(0x1d4ed8)
@Stable
val Blue800 = color(0x1e40af)
@Stable
val Blue900 = color(0x1e3a8a)

/// Indigo
@Stable
val Indigo50 = color(0xeef2ff)
@Stable
val Indigo100 = color(0xe0e7ff)
@Stable
val Indigo200 = color(0xc7d2fe)
@Stable
val Indigo300 = color(0xa5b4fc)
@Stable
val Indigo400 = color(0x818cf8)
@Stable
val Indigo500 = color(0x6366f1)
@Stable
val Indigo600 = color(0x4f46e5)
@Stable
val Indigo700 = color(0x4338ca)
@Stable
val Indigo800 = color(0x3730a3)
@Stable
val Indigo900 = color(0x312e81)

/// Violet
@Stable
val Violet50 = color(0xf5f3ff)
@Stable
val Violet100 = color(0xede9fe)
@Stable
val Violet200 = color(0xddd6fe)
@Stable
val Violet300 = color(0xc4b5fd)
@Stable
val Violet400 = color(0xa78bfa)
@Stable
val Violet500 = color(0x8b5cf6)
@Stable
val Violet600 = color(0x7c3aed)
@Stable
val Violet700 = color(0x6d28d9)
@Stable
val Violet800 = color(0x5b21b6)
@Stable
val Violet900 = color(0x4c1d95)

/// Purple
@Stable
val Purple50 = color(0xfaf5ff)
@Stable
val Purple100 = color(0xf3e8ff)
@Stable
val Purple200 = color(0xe9d5ff)
@Stable
val Purple300 = color(0xd8b4fe)
@Stable
val Purple400 = color(0xc084fc)
@Stable
val Purple500 = color(0xa855f7)
@Stable
val Purple600 = color(0x9333ea)
@Stable
val Purple700 = color(0x7e22ce)
@Stable
val Purple800 = color(0x6b21a8)
@Stable
val Purple900 = color(0x581c87)

/// Fuchsia
@Stable
val Fuchsia50 = color(0xfdf4ff)
@Stable
val Fuchsia100 = color(0xfae8ff)
@Stable
val Fuchsia200 = color(0xf5d0fe)
@Stable
val Fuchsia300 = color(0xf0abfc)
@Stable
val Fuchsia400 = color(0xe879f9)
@Stable
val Fuchsia500 = color(0xd946ef)
@Stable
val Fuchsia600 = color(0xc026d3)
@Stable
val Fuchsia700 = color(0xa21caf)
@Stable
val Fuchsia800 = color(0x86198f)
@Stable
val Fuchsia900 = color(0x701a75)

/// Pink
@Stable
val Pink50 = color(0xfdf2f8)
@Stable
val Pink100 = color(0xfce7f3)
@Stable
val Pink200 = color(0xfbcfe8)
@Stable
val Pink300 = color(0xf9a8d4)
@Stable
val Pink400 = color(0xf472b6)
@Stable
val Pink500 = color(0xec4899)
@Stable
val Pink600 = color(0xdb2777)
@Stable
val Pink700 = color(0xbe185d)
@Stable
val Pink800 = color(0x9d174d)
@Stable
val Pink900 = color(0x831843)

/// Rose
@Stable
val Rose50 = color(0xfff1f2)
@Stable
val Rose100 = color(0xffe4e6)
@Stable
val Rose200 = color(0xfecdd3)
@Stable
val Rose300 = color(0xfda4af)
@Stable
val Rose400 = color(0xfb7185)
@Stable
val Rose500 = color(0xf43f5e)
@Stable
val Rose600 = color(0xe11d48)
@Stable
val Rose700 = color(0xbe123c)
@Stable
val Rose800 = color(0x9f1239)
@Stable
val Rose900 = color(0x881337)