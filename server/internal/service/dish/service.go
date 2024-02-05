package dish

import "dishServer/internal/app"

type dishService struct {
	dishRepo app.DishRepo
}

func NewService(dishRepo app.DishRepo) app.DishService {
	return &dishService{
		dishRepo: dishRepo,
	}
}
