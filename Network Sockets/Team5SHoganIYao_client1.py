#Team 5
#Sean Hogan K00276275
#Ishka Yao K0027040
#Client socket

#  Run sockets in python 3

import socket

HOST = '192.168.100.20'
PORT = 65432

# Create a socket with address family IPv4 and socket type TCP
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
print("\nConnecting to {}:{}".format(HOST.PORT))
s.connect((HOST, PORT)) # connect to server with IP and port

name = input("Enter Name:") # prompt to enter name
print("\nSending Name\n")

s.sendall(name.encode())    # send name input to server to be checked

data = s.recv(1024) # receive data from server
s.close() # close socket

print(data.decode()) # print the received data