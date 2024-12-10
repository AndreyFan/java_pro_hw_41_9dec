package de.telran.onlineshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineShopApplication {
//  1 уровень сложности: Добавьте тесты для слоя контроллеров на все методы CRUD.
//1) Users - пользователи
//2) Products - товары
//3) Cart - корзина
//4) CartItems - товары в корзине
//5) Orders - заказы
//6) OrderItems - товары в заказе
//7) Favorites - избранные товары
//8) Categories - категории товаров.
	//  Сделал тесты для Контроллеров на все классы в которых были реализации контроллеров и сервисов к ним

	public static void main(String[] args) {
		SpringApplication.run(OnlineShopApplication.class, args);
	}

}
