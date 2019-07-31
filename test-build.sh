#!/bin/bash
/usr/local/bin/docker-compose -f basic-compose.yml down --rmi all

/usr/local/bin/docker-compose -f test-compose.yml down --rmi all

/usr/local/bin/docker-compose -f basic-compose.yml up -d

/usr/local/bin/docker-compose -f test-compose.yml up -d
