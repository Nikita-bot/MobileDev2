package dish

import "dishServer/internal/app/entity"

func (r *dishRepo) Get(dishId string) (entity.Dish, error) {
	return entity.Dish{}, nil
}
func(r *dishRepo)GetFavorite(user_id int){
	
}
func (r *dishRepo) AddFavorite(dish entity.Dish) error {
	return nil
}
func (r *dishRepo) DeleteFavorite(dishId string) error {
	return nil
}
