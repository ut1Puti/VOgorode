class User:
    def __init__(self, u_id, u_type, login, email, telephone, creation_date, update_date):
        self.u_id = u_id
        self.u_type = u_type
        self.login = login
        self.email = email
        self.telephone = telephone
        self.creation_date = creation_date
        self.update_date = update_date


def generate_data():
    pass


data = list()

for _ in range(0, 3_000_000):
    data.append(generate_data())

with open('data.txt', 'w') as file:
    for e in data:
        file.write(str(e) + '\n')
