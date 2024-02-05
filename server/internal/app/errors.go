package app

import "errors"

var (
	ErrNotFound     = errors.New("Not found")
	ErrAlreadyExist = errors.New("Already exist")
)
