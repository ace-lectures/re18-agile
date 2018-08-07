#! /bin/sh

# Start the OpenSSH server, also as a daemon
/usr/sbin/sshd -D &

# Start the Nginx web server
nginx -g "daemon off;"

