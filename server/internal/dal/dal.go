package dal

import (
	"dishServer/internal/app"
	"dishServer/internal/dal/dish"
	"dishServer/internal/dal/user"

	"github.com/gocraft/dbr/v2"
)

func NewRepositories(db *dbr.Connection) *app.Repositories {
	return &app.Repositories{
		DishRepo: dish.NewRepo(db),
		UserRepo: user.NewRepo(db),
	}
}
