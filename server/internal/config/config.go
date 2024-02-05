package config

import (
	"errors"
	"fmt"
	"os"

	"github.com/caarlos0/env/v9"
	"github.com/joho/godotenv"
)

type (
	Config struct {
		Port           int    `env:"HTTP_PORT" envDefault:"8080"`
		BasePath       string `env:"HTTP_BASE_PATH" envDefault:""`
		AllowedOrigins string `env:"HTTP_ALLOWED_ORIGINS" envDefault:"*"`
		Host           string `env:"HTTP_HOST" envDefault:"0.0.0.0"`
		LogLevel       string `env:"LOG_LEVEL" envDefault:"INFO"`
		DB             DBConfig
	}

	DBConfig struct {
		Host          string `env:"DB_HOST" envDefault:"localhost"`
		Port          int    `env:"DB_PORT" envDefault:"5432"`
		Database      string `env:"DB_DATABASE" envDefault:"my_food_book"`
		User          string `env:"DB_USER" envDefault:"postgres"`
		Password      string `env:"DB_PASSWORD" envDefault:"Nikitapazderin1"`
		PingTimeout   int    `env:"DB_PING_TIMEOUT" envDefault:"10"`
		MigrationsDir string `env:"DB_MIGRATIONS_DIR" envDefault:"migrations"`
	}
)

func NewConfig(configFiles ...string) (Config, error) {
	var c Config
	err := godotenv.Load(configFiles...)
	if err != nil {
		if !errors.Is(err, os.ErrNotExist) {
			return Config{}, err
		}
	}

	err = env.ParseWithOptions(&c, env.Options{RequiredIfNoDef: true})
	if err != nil {
		return Config{}, err
	}

	return c, nil
}

func (c DBConfig) DSN() string {
	return fmt.Sprintf("user=%s password=%s dbname=%s host=%s port=%d sslmode=disable",
		c.User, c.Password, c.Database, c.Host, c.Port)
}
