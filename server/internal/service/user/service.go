package user

import "dishServer/internal/app"

type userService struct {
	userRepo app.UserRepo
}

func NewService(userRepo app.UserRepo) app.UserService {
	return &userService{
		userRepo: userRepo,
	}
}
