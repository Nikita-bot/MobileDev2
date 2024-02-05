package handler

import (
	"dishServer/internal/app"

	"github.com/gin-gonic/gin"
)

type Handler struct {
	service *app.Services
}

func NewHandler(services *app.Services) *Handler {
	return &Handler{service: services}
}

func (h *Handler) InitRoutes() *gin.Engine {

	router := gin.New()

	api := router.Group("/")
	{
		api.POST("/reg", h.reg)
		api.GET("/auth", h.auth)
		api.GET("/all", h.getAll)
		api.GET("/favorite", h.getFavorite)
		api.POST("/favorite", h.newFavorite)
	}

	return router

}
