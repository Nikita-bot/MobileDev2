package db

import (
	"context"
	"database/sql"
	"log"
	"time"

	"github.com/gocraft/dbr/v2"
	_ "github.com/lib/pq"
	"github.com/pressly/goose"
)

func InitDB(dsn string) (*dbr.Connection, error) {
	dbpool, err := dbr.Open("postgres", dsn, nil)
	if err != nil {
		return nil, err
	}

	ctx, cancel := context.WithTimeout(context.Background(), 10*time.Second)
	defer cancel()

	err = dbpool.PingContext(ctx)

	if err != nil {
		return nil, err
	}

	dbpool.SetMaxOpenConns(10)
	dbpool.SetConnMaxLifetime(20 * time.Second)
	dbpool.SetConnMaxIdleTime(60 * time.Second)

	// Optionally log a message indicating a successful connection
	log.Println("Connected to the database!")

	// Close the database connection before returning

	return dbpool, nil
}

func UpMigrations(db *sql.DB, dir string) error {

	if err := goose.SetDialect("postgres"); err != nil {
		return err
	}

	if err := goose.Up(db, dir); err != nil {
		return err
	}

	return nil
}
