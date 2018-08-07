FROM nginx:alpine

# Installing OpenSSH
RUN apk update \
    && apk add --no-cache openssh \
    && ssh-keygen -f /etc/ssh/ssh_host_rsa_key -N '' -t rsa

# Configure OpenSSH in a very insecure way. Don't do this at home!
RUN echo root:re18 | chpasswd \
    && echo 'PermitRootLogin yes' > /etc/ssh/sshd_config

# Configure nginx to support directory listing
ADD ./nginx.config /etc/nginx/conf.d/default.conf

# Starting both Nginx and OpenSSH when starting the container
ADD ./start.sh .
RUN chmod u+x ./start.sh

# Running the startup script when instatiating the container
CMD [ "./start.sh" ]