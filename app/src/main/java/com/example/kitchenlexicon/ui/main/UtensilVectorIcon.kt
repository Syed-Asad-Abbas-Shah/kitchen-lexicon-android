package com.example.kitchenlexicon.ui.main

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke

@Composable
fun UtensilVectorIcon(
    id: String,
    category: String,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height

        // Define premium color palettes
        val steelGrad = Brush.linearGradient(
            colors = listOf(Color(0xFFCBD5E1), Color(0xFF94A3B8), Color(0xFF475569)),
            start = Offset(0f, 0f),
            end = Offset(w, h)
        )
        val woodGrad = Brush.horizontalGradient(
            colors = listOf(Color(0xFFB45309), Color(0xFF78350F)),
            startX = 0f,
            endX = w
        )
        val brassColor = Color(0xFFD97706)
        val siliconeColor = Color(0xFF0EA5E9)
        val redColor = Color(0xFFEF4444)

        when (id) {
            "chefs-knife" -> {
                // Blade
                val blade = Path().apply {
                    moveTo(w * 0.25f, h * 0.60f)
                    lineTo(w * 0.75f, h * 0.60f)
                    quadraticTo(w * 0.88f, h * 0.58f, w * 0.94f, h * 0.48f)
                    quadraticTo(w * 0.65f, h * 0.42f, w * 0.25f, h * 0.42f)
                    close()
                }
                drawPath(blade, steelGrad)
                drawPath(blade, Color(0xFF475569), style = Stroke(width = 2f))
                
                // Bolster
                drawRoundRect(brassColor, Offset(w * 0.22f, h * 0.42f), Size(w * 0.03f, h * 0.18f), CornerRadius(2f, 2f))
                
                // Wood Handle
                val handle = Path().apply {
                    moveTo(w * 0.05f, h * 0.45f)
                    lineTo(w * 0.22f, h * 0.45f)
                    lineTo(w * 0.22f, h * 0.57f)
                    lineTo(w * 0.05f, h * 0.57f)
                    close()
                }
                drawPath(handle, woodGrad)
                drawPath(handle, Color(0xFF451A03), style = Stroke(width = 2f))
                
                // Rivets
                drawCircle(Color.White, radius = w * 0.015f, center = Offset(w * 0.09f, h * 0.51f))
                drawCircle(Color.White, radius = w * 0.015f, center = Offset(w * 0.16f, h * 0.51f))
            }
            "paring-knife" -> {
                // Small Blade
                val blade = Path().apply {
                    moveTo(w * 0.40f, h * 0.54f)
                    lineTo(w * 0.85f, h * 0.54f)
                    quadraticTo(w * 0.91f, h * 0.52f, w * 0.93f, h * 0.48f)
                    quadraticTo(w * 0.72f, h * 0.46f, w * 0.40f, h * 0.46f)
                    close()
                }
                drawPath(blade, steelGrad)
                drawPath(blade, Color(0xFF475569), style = Stroke(width = 1.5f))
                // Handle
                drawRect(Color(0xFF334155), Offset(w * 0.10f, h * 0.48f), Size(w * 0.30f, h * 0.05f))
            }
            "bread-knife" -> {
                // Serrated blade
                val blade = Path().apply {
                    moveTo(w * 0.25f, h * 0.48f)
                    lineTo(w * 0.85f, h * 0.48f)
                    lineTo(w * 0.90f, h * 0.54f)
                    lineTo(w * 0.25f, h * 0.54f)
                    close()
                }
                drawPath(blade, steelGrad)
                drawPath(blade, Color(0xFF475569), style = Stroke(width = 1.5f))
                // Wood Handle
                drawRect(woodGrad, Offset(w * 0.05f, h * 0.47f), Size(w * 0.20f, h * 0.08f))
            }
            "peeler" -> {
                // Handle
                drawRoundRect(Color(0xFF0284C7), Offset(w * 0.42f, h * 0.55f), Size(w * 0.16f, h * 0.35f), CornerRadius(6f, 6f))
                // Y-Arms
                val arms = Path().apply {
                    moveTo(w * 0.30f, h * 0.35f)
                    lineTo(w * 0.42f, h * 0.55f)
                    moveTo(w * 0.58f, h * 0.55f)
                    lineTo(w * 0.70f, h * 0.35f)
                }
                drawPath(arms, Color(0xFF64748B), style = Stroke(width = 5f))
                // Blade
                drawRoundRect(Color(0xFFCBD5E1), Offset(w * 0.34f, h * 0.30f), Size(w * 0.32f, h * 0.06f), CornerRadius(2f, 2f))
            }
            "box-grater" -> {
                // Handle
                val handle = Path().apply {
                    moveTo(w * 0.35f, h * 0.25f)
                    cubicTo(w * 0.35f, h * 0.15f, w * 0.65f, h * 0.15f, w * 0.65f, h * 0.25f)
                }
                drawPath(handle, brassColor, style = Stroke(width = 6f))
                
                // Body
                val body = Path().apply {
                    moveTo(w * 0.30f, h * 0.85f)
                    lineTo(w * 0.35f, h * 0.25f)
                    lineTo(w * 0.65f, h * 0.25f)
                    lineTo(w * 0.70f, h * 0.85f)
                    close()
                }
                drawPath(body, steelGrad)
                drawPath(body, Color(0xFF475569), style = Stroke(width = 3f))
            }
            "whisk" -> {
                // Handle
                drawRoundRect(steelGrad, Offset(w * 0.44f, h * 0.55f), Size(w * 0.12f, h * 0.35f), CornerRadius(4f, 4f))
                // Collar
                drawRect(brassColor, Offset(w * 0.42f, h * 0.50f), Size(w * 0.16f, h * 0.05f))
                // Wire loops
                val loop1 = Path().apply {
                    moveTo(w * 0.50f, h * 0.50f)
                    cubicTo(w * 0.20f, h * 0.35f, w * 0.25f, h * 0.10f, w * 0.50f, h * 0.10f)
                    cubicTo(w * 0.75f, h * 0.10f, w * 0.80f, h * 0.35f, w * 0.50f, h * 0.50f)
                }
                drawPath(loop1, Color(0xFF94A3B8), style = Stroke(width = 3f))
                val loop2 = Path().apply {
                    moveTo(w * 0.50f, h * 0.50f)
                    cubicTo(w * 0.30f, h * 0.38f, w * 0.35f, h * 0.15f, w * 0.50f, h * 0.15f)
                    cubicTo(w * 0.65f, h * 0.15f, w * 0.70f, h * 0.38f, w * 0.50f, h * 0.50f)
                }
                drawPath(loop2, Color(0xFF94A3B8), style = Stroke(width = 2f))
            }
            "spatula" -> {
                // Handle
                drawLine(Color(0xFF94A3B8), Offset(w * 0.50f, h * 0.90f), Offset(w * 0.50f, h * 0.50f), strokeWidth = 6f)
                // Head
                val head = Path().apply {
                    moveTo(w * 0.30f, h * 0.50f)
                    lineTo(w * 0.70f, h * 0.50f)
                    lineTo(w * 0.65f, h * 0.15f)
                    lineTo(w * 0.35f, h * 0.15f)
                    close()
                }
                drawPath(head, steelGrad)
            }
            "silicone-spatula" -> {
                // Handle
                drawLine(Color(0xFF78350F), Offset(w * 0.50f, h * 0.90f), Offset(w * 0.50f, h * 0.45f), strokeWidth = 8f)
                // Scraper Head
                val head = Path().apply {
                    moveTo(w * 0.38f, h * 0.45f)
                    lineTo(w * 0.62f, h * 0.45f)
                    quadraticTo(w * 0.65f, h * 0.45f, w * 0.65f, h * 0.40f)
                    lineTo(w * 0.55f, h * 0.15f)
                    lineTo(w * 0.38f, h * 0.15f)
                    close()
                }
                drawPath(head, siliconeColor)
                drawPath(head, Color(0xFF0284C7), style = Stroke(width = 2f))
            }
            "tongs" -> {
                // Core arm spring
                drawCircle(brassColor, radius = w * 0.05f, center = Offset(w * 0.50f, h * 0.18f), style = Stroke(width = 4f))
                // Left arm
                drawLine(Color(0xFF64748B), Offset(w * 0.48f, h * 0.22f), Offset(w * 0.30f, h * 0.85f), strokeWidth = 6f)
                // Right arm
                drawLine(Color(0xFF64748B), Offset(w * 0.52f, h * 0.22f), Offset(w * 0.70f, h * 0.85f), strokeWidth = 6f)
                // Grippers
                drawRoundRect(redColor, Offset(w * 0.25f, h * 0.80f), Size(w * 0.08f, h * 0.06f), CornerRadius(4f, 4f))
                drawRoundRect(redColor, Offset(w * 0.67f, h * 0.80f), Size(w * 0.08f, h * 0.06f), CornerRadius(4f, 4f))
            }
            "ladle" -> {
                // Curved Handle
                val handle = Path().apply {
                    moveTo(w * 0.75f, h * 0.15f)
                    quadraticTo(w * 0.75f, h * 0.10f, w * 0.65f, h * 0.15f)
                    lineTo(w * 0.35f, h * 0.65f)
                }
                drawPath(handle, Color(0xFF94A3B8), style = Stroke(width = 6f))
                // Bowl
                val bowl = Path().apply {
                    moveTo(w * 0.12f, h * 0.65f)
                    cubicTo(w * 0.12f, h * 0.85f, w * 0.42f, h * 0.85f, w * 0.42f, h * 0.65f)
                    close()
                }
                drawPath(bowl, steelGrad)
            }
            "colander" -> {
                // Bowl
                val bowl = Path().apply {
                    moveTo(w * 0.15f, h * 0.45f)
                    cubicTo(w * 0.15f, h * 0.75f, w * 0.35f, h * 0.80f, w * 0.50f, h * 0.80f)
                    cubicTo(w * 0.65f, h * 0.80f, w * 0.85f, h * 0.75f, w * 0.85f, h * 0.45f)
                    close()
                }
                drawPath(bowl, steelGrad)
                drawPath(bowl, Color(0xFF475569), style = Stroke(width = 3f))
                // Feet Stand
                drawRect(Color(0xFF475569), Offset(w * 0.35f, h * 0.80f), Size(w * 0.30f, h * 0.05f))
                // Handles
                drawCircle(brassColor, radius = w * 0.05f, center = Offset(w * 0.10f, h * 0.52f), style = Stroke(width = 4f))
                drawCircle(brassColor, radius = w * 0.05f, center = Offset(w * 0.90f, h * 0.52f), style = Stroke(width = 4f))
                // Holes (dots)
                drawCircle(Color.Black, radius = 3f, center = Offset(w * 0.50f, h * 0.55f))
                drawCircle(Color.Black, radius = 3f, center = Offset(w * 0.42f, h * 0.60f))
                drawCircle(Color.Black, radius = 3f, center = Offset(w * 0.58f, h * 0.60f))
                drawCircle(Color.Black, radius = 3f, center = Offset(w * 0.50f, h * 0.68f))
            }
            "wooden-spoon" -> {
                // Handle
                drawLine(Color(0xFF78350F), Offset(w * 0.50f, h * 0.90f), Offset(w * 0.50f, h * 0.45f), strokeWidth = 12f)
                // Scoop head
                drawOval(woodGrad, Offset(w * 0.38f, h * 0.15f), Size(w * 0.24f, h * 0.30f))
            }
            "measuring-cups" -> {
                // Stack of cups
                drawLine(Color(0xFF94A3B8), Offset(w * 0.45f, h * 0.40f), Offset(w * 0.15f, h * 0.40f), strokeWidth = 8f)
                val cup = Path().apply {
                    moveTo(w * 0.40f, h * 0.30f)
                    lineTo(w * 0.80f, h * 0.30f)
                    lineTo(w * 0.75f, h * 0.65f)
                    quadraticTo(w * 0.58f, h * 0.75f, w * 0.41f, h * 0.65f)
                    close()
                }
                drawPath(cup, steelGrad)
            }
            "stockpot" -> {
                // Pot body
                drawRoundRect(steelGrad, Offset(w * 0.15f, h * 0.32f), Size(w * 0.70f, h * 0.50f), CornerRadius(6f, 6f))
                // Handles
                drawCircle(brassColor, radius = w * 0.04f, center = Offset(w * 0.11f, h * 0.50f), style = Stroke(width = 4f))
                drawCircle(brassColor, radius = w * 0.04f, center = Offset(w * 0.89f, h * 0.50f), style = Stroke(width = 4f))
                // Lid
                val lid = Path().apply {
                    moveTo(w * 0.13f, h * 0.32f)
                    lineTo(w * 0.87f, h * 0.32f)
                    lineTo(w * 0.80f, h * 0.24f)
                    lineTo(w * 0.20f, h * 0.24f)
                    close()
                }
                drawPath(lid, Color(0xFF475569))
                drawCircle(brassColor, radius = w * 0.04f, center = Offset(w * 0.50f, h * 0.20f))
            }
            "skillet" -> {
                // Frying pan sloped shape
                drawLine(Color(0xFF334155), Offset(w * 0.50f, h * 0.75f), Offset(w * 0.85f, h * 0.85f), strokeWidth = 8f)
                drawOval(steelGrad, Offset(w * 0.15f, h * 0.32f), Size(w * 0.50f, h * 0.36f))
                drawOval(Color(0xFF0F172A), Offset(w * 0.17f, h * 0.34f), Size(w * 0.46f, h * 0.32f))
            }
            else -> {
                // Generic visual fallback drawing representing its category
                when (category) {
                    "cutting" -> {
                        // General cutting tool representation (stylized shears/chopper)
                        drawLine(Color(0xFF64748B), Offset(w * 0.20f, h * 0.80f), Offset(w * 0.80f, h * 0.20f), strokeWidth = 8f)
                        val blade = Path().apply {
                            moveTo(w * 0.50f, h * 0.50f)
                            lineTo(w * 0.80f, h * 0.20f)
                            lineTo(w * 0.90f, h * 0.30f)
                            lineTo(w * 0.60f, h * 0.60f)
                            close()
                        }
                        drawPath(blade, steelGrad)
                        drawCircle(brassColor, radius = w * 0.06f, center = Offset(w * 0.20f, h * 0.80f))
                    }
                    "stirring" -> {
                        // General spoon/stirrer
                        drawLine(brassColor, Offset(w * 0.50f, h * 0.90f), Offset(w * 0.50f, h * 0.40f), strokeWidth = 6f)
                        drawOval(steelGrad, Offset(w * 0.35f, h * 0.15f), Size(w * 0.30f, h * 0.25f))
                    }
                    "baking" -> {
                        // General baking tool (stylized bowl/roller)
                        drawRoundRect(woodGrad, Offset(w * 0.10f, h * 0.40f), Size(w * 0.80f, h * 0.20f), CornerRadius(10f, 10f))
                    }
                    "measuring" -> {
                        // Dial/Display representation
                        drawCircle(steelGrad, radius = w * 0.35f, center = Offset(w * 0.50f, h * 0.50f), style = Stroke(width = 6f))
                        drawLine(redColor, Offset(w * 0.50f, h * 0.50f), Offset(w * 0.70f, h * 0.30f), strokeWidth = 4f)
                        drawCircle(Color(0xFF334155), radius = 6f, center = Offset(w * 0.50f, h * 0.50f))
                    }
                    "straining" -> {
                        // Sieve mesh circle
                        drawCircle(steelGrad, radius = w * 0.35f, center = Offset(w * 0.50f, h * 0.50f), style = Stroke(width = 6f))
                        for (i in 3..7) {
                            drawLine(Color(0xFF64748B), Offset(w * 0.20f, h * 0.1f * i), Offset(w * 0.80f, h * 0.1f * i), strokeWidth = 2f)
                            drawLine(Color(0xFF64748B), Offset(w * 0.1f * i, h * 0.20f), Offset(w * 0.1f * i, h * 0.80f), strokeWidth = 2f)
                        }
                    }
                    "opening" -> {
                        // Key / Wing representation
                        drawCircle(brassColor, radius = w * 0.15f, center = Offset(w * 0.50f, h * 0.25f), style = Stroke(width = 5f))
                        drawLine(Color(0xFF94A3B8), Offset(w * 0.50f, h * 0.40f), Offset(w * 0.50f, h * 0.85f), strokeWidth = 8f)
                        drawLine(Color(0xFF94A3B8), Offset(w * 0.30f, h * 0.55f), Offset(w * 0.70f, h * 0.55f), strokeWidth = 6f)
                    }
                    else -> {
                        // General Pot/Pan Cookware Vessel
                        drawRoundRect(steelGrad, Offset(w * 0.20f, h * 0.35f), Size(w * 0.60f, h * 0.45f), CornerRadius(10f, 10f))
                        drawLine(Color(0xFF475569), Offset(w * 0.15f, h * 0.35f), Offset(w * 0.85f, h * 0.35f), strokeWidth = 4f)
                        drawCircle(brassColor, radius = w * 0.05f, center = Offset(w * 0.50f, h * 0.28f))
                    }
                }
            }
        }
    }
}
