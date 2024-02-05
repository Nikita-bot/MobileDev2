package user

import "dishServer/internal/app/entity"

func (r *userRepo) Create(user entity.User) error {
	return nil
}
func (r *userRepo) Auth(user entity.User) error {
	return nil
}
func (r *userRepo) CheckInDB(userId string) error {
	return nil
}
