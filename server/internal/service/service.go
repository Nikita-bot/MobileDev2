package service

import (
	"dishServer/internal/app"
	"dishServer/internal/service/dish"
	"dishServer/internal/service/user"
)

func NewService(dal *app.Repositories) *app.Services {
	return &app.Services{
		UserService: user.NewService(dal.UserRepo),
		DishService: dish.NewService(dal.DishRepo),
	}
}
