#!/bin/bash
#set -x
set -eo pipefail
shopt -s nullglob

for file in ./*-compose.yml; do
    echo "deleting images..."
    docker-compose -f "$file" down --rmi all
done