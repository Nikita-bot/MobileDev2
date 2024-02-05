package app

type (
	Repositories struct {
		UserRepo UserRepo
		DishRepo DishRepo
	}

	Services struct {
		UserService UserService
		DishService DishService
	}
)
