package com.example.pricetraker.provider.productos

import com.example.pricetraker.data.DataProducto
class NotebookProvider {
    companion object {
        val listaDataProducto = listOf<DataProducto>(
            DataProducto(
                "HP",
                "Pavilion Aero Aero 13-BE0502LA",
                "https://media.solotodo.com/media/cache/0f/66/0f6603b538e9de6f753099c71c57b954.png",
                729990,
            ),
            DataProducto(
                "Lenovo",
                "IdeaPad 5 14IIL05",
                "https://media.solotodo.com/media/cache/46/fd/46fdfbdcbcbc2d007dab18982c577a36.png",
                819991,
            ),
            DataProducto(
                "Honor",
                "MagicBook X14 [53011WCD]",
                "https://media.solotodo.com/media/cache/fe/f0/fef0511a441f6dd957ea3d070372b43e.png",
                569990,
            ),
            DataProducto(
                "Lenovo",
                "IdeaPad 1 14IGL05",
                "https://media.solotodo.com/media/cache/19/9a/199a82b48bb2ba45cbe945d51c650834.png",
                229990,
            )
        )
    }
}


