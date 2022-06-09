package com.example.pricetraker.provider.categorias

import com.example.pricetraker.data.DataCategorias

class CategoriasDestacadasProvider {
    companion object{
        val listaDataCategoriasDestacadas = listOf<DataCategorias>(

            DataCategorias(
                "Notebook",
                "Tecnologia",
                "https://i.blogs.es/f32047/xiaomi-mi-notebook/450_1000.jpg",
                1),
            DataCategorias(
                "Lacteos",
                "Supermercado",
                "https://mejorconsalud.as.com/fitness/wp-content/uploads/2019/06/productos-lacteos-queso-leche-yogur.jpg",
                2),
            DataCategorias(
                "Smartphone",
                "Tecnologia",
                "https://media.wired.com/photos/621980b1aaf30ea1c35e400a/191:100/w_2580,c_limit/Gear-Samsung-S22-Series.jpg",
                3),
            DataCategorias(
                "Consolas",
                "Tecnologia",
                "https://s3.amazonaws.com/businessinsider.mx/wp-content/uploads/2021/12/08164547/Comparacio%CC%81n-de-consolas.jpg",
                4),
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