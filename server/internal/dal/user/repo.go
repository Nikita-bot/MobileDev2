package user

import (
	"dishServer/internal/app"

	"github.com/gocraft/dbr/v2"
)

type userRepo struct {
	db *dbr.Connection
}

func NewRepo(db *dbr.Connection) app.UserRepo {
	return &userRepo{
		db: db,
	}
}
