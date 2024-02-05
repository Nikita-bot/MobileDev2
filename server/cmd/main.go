package main

import (
	server "dishServer"
	"dishServer/internal/config"
	"dishServer/internal/dal"
	"dishServer/internal/handler"
	"dishServer/internal/pkg/db"
	"dishServer/internal/service"
	"log"
)

func main() {
	cfg, err := config.NewConfig()
	if err != nil {
		log.Fatal("init config: ", err)
	}

	dbConn, err := db.InitDB(cfg.DB.DSN())

	if err != nil {
		log.Fatal("init DB: ", err)
	}

	defer dbConn.Close()

	repositories := dal.NewRepositories(dbConn)
	services := service.NewService(repositories)
	handler := handler.NewHandler(services)

	srv := new(server.Server)
	if err := srv.Run("8080", handler.InitRoutes()); err != nil {
		log.Fatal("Server run: ", err)
	}

}
