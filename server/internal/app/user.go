package app

import "dishServer/internal/app/entity"

type (
	UserService interface {
		Create(user entity.User) error
		Auth(user entity.User) error
	}

	UserRepo interface {
		Create(user entity.User) error
		Auth(user entity.User) error
		CheckInDB(userId string) error
	}
)
