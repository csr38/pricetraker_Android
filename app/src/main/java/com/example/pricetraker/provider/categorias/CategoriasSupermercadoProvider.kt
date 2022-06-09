package com.example.pricetraker.provider.categorias

import com.example.pricetraker.data.DataCategorias

class CategoriasSupermercadoProvider {
    companion object{
        val listaDataCategoriasDestacadas = listOf<DataCategorias>(

            DataCategorias(
                "Lacteos",
                "Supermercado",
                "https://mejorconsalud.as.com/fitness/wp-content/uploads/2019/06/productos-lacteos-queso-leche-yogur.jpg",
                2),
            DataCategorias(
                "Bebidas",
                "Supermercado",
                "https://fusionpurpura.cl/catalogo/wp-content/uploads/2020/04/bebidas-2.jpg",
                5),
            DataCategorias(
                "Licores",
                "Supermercado",
                "https://saboryestilo.com.mx/wp-content/uploads/elementor/thumbs/Vino-Licor-Diferencias-oujfq7sf2joeoippsdsqfykh5172tk8jgjagwd3i2o.jpg",
                6)
        )
    }
}