package dish

import (
	"dishServer/internal/app"

	"github.com/gocraft/dbr/v2"
)

type dishRepo struct {
	db *dbr.Connection
}

func NewRepo(db *dbr.Connection) app.DishRepo {
	return &dishRepo{
		db: db,
	}
}
