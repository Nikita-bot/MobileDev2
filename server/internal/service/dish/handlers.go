package dish

import "dishServer/internal/app/entity"

func (srv *dishService) Get(dishId string) (entity.Dish, error) {
	return entity.Dish{}, nil
}
func (srv *dishService) Upsert(dish entity.Dish) (entity.Dish, error) {
	return entity.Dish{}, nil
}
