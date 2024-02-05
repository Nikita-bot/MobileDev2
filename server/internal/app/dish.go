package app

import "dishServer/internal/app/entity"

type (
	DishService interface {
		Get(dishId string) (entity.Dish, error)
		Upsert(dish entity.Dish) (entity.Dish, error)
	}
	DishRepo interface {
		Get(dishId string) (entity.Dish, error)
		AddFavorite(dish entity.Dish) error
		DeleteFavorite(dishId string) error
	}
)
